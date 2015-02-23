/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import java.util.ArrayList;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Comment;
import service.WebLogService;
import model.Posting;
import java.io.IOException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Date;

/**
 *
 * @author Tijron
 */
public class Controller extends HttpServlet {

    private void replyError(HttpServletRequest request, HttpServletResponse response, final String message) throws IOException
    {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<link href=\""+request.getContextPath()+"/main.css\" rel=\"stylesheet\" type=\"text/css\"/>");
            out.println("<title>Servlet Controller</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>An error has occured! </h1>");
            out.println("<div class=\"error_msg\">"+message+"</div>");
            out.println("<a href=\""+request.getContextPath()+"\">Go back to index.</a>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    
    public static final String MSG_TITLE_PARAM = "msgTitle";
    public static final String MSG_TEXT_PARAM = "msgText";
    public static final String MSG_DO_PARAM = "addMsg";
    public static final String ERROR_LIST_ARRT = "errors";
    public static final String PREV_MSG_TITLE_ARRT = MSG_TITLE_PARAM;
    public static final String PREV_MSG_TEXT_ARRT = MSG_TEXT_PARAM;
    
    private String processAdminRequest(HttpServletRequest request)
    {
        String title = request.getParameter(MSG_TITLE_PARAM );
        String text = request.getParameter(MSG_TEXT_PARAM );

        final boolean isMsgTitleEmpty = (title == null || title.trim().equals(""));
        final boolean isMsgTextEmpty = (text == null || text.trim().equals(""));
        if( request.getParameter(MSG_DO_PARAM) != null && ( isMsgTitleEmpty || isMsgTextEmpty) )
        {
            List<String> errors = new ArrayList();
            if(isMsgTitleEmpty)
            {
                errors.add("The message title is empty!");
            }
            else
            {
                request.setAttribute(PREV_MSG_TITLE_ARRT,title);
            }
            if(isMsgTextEmpty)
            {
                errors.add("The message text is empty!");
            }
            else
            {
                request.setAttribute(PREV_MSG_TEXT_ARRT,text);
            }
            request.setAttribute(ERROR_LIST_ARRT, errors);
        }
        else
        {
            WebLogService.getInstance().addPosting(title, text);
        }
        
        return "WeblogAdmin";
    }
    
    public static final String POSTST_ATTR = "posts";
    
    private String processViewRequest(HttpServletRequest request)
    {
        List<Posting> posts = WebLogService.getInstance().getPostings();
        request.setAttribute(POSTST_ATTR, posts);
        return "Weblog";
    }

    public static final String MSG_COMMENT_PARAM = "msgComment";
    public static final String MSG_ID_PARAM = "msgId";
    public static final String POST_ATTR = "post";
    private static final String DO_AJAX_RESP = "do-ajax-rest";
    
    private String processPostRequest(HttpServletRequest request)
    {
        final long postId = Long.parseLong(request.getParameter(MSG_ID_PARAM));
        Posting post = WebLogService.getInstance().getPost(postId);
        request.setAttribute(POST_ATTR, post);
        return "WeblogPost";
    }
    
    public static final String convertToString(Date input)
    {
        Instant instant = input.toInstant();
        ZonedDateTime zdt = instant.atZone(ZoneId.systemDefault());
        LocalDateTime date = zdt.toLocalDateTime();
        return date.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT));
    }
    
    private String processCommRequest(HttpServletRequest request, HttpServletResponse response)
    {
        //Get the post
        final long postId = Long.parseLong(request.getParameter(MSG_ID_PARAM));
        Posting post = WebLogService.getInstance().getPost(postId);
        
        //Add the comment
        final String comment = request.getParameter(MSG_COMMENT_PARAM);
        if(comment != null && !comment.trim().equals(""))
        {
            //Add a new comment
            List<Comment> comments = post.getComments();
            comments.add(new Comment(post.getId(), comment));
            post.setComments( comments );
            //Store the update in the DAO
            WebLogService.getInstance().updatePosting(post);
        }
        
        //Create a response
        StringBuilder sb = new StringBuilder();
        post.getComments().forEach( comm -> {
            sb.append("<comment>");
            sb.append("<content>");
            sb.append(comm.getContent());
            sb.append("</content>");
            sb.append("<date>");
            sb.append(convertToString(comm.getDate()));
            sb.append("</date>");
            sb.append("</comment>");
        });

        response.setContentType("text/xml;charset=UTF-8");
        try( PrintWriter out = response.getWriter())
        {
            out.println("<comments>"+sb.toString()+"</comments>");
        }catch(IOException e)
        {
            System.err.println(e);
        }
        return DO_AJAX_RESP;
    }
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Get the path and see if an action with redirect is needed.
        String userPath = request.getRequestURI().substring(request.getContextPath().length());
        String action = null;
        if( userPath != null) {
            if (userPath.equals("/admin")) {
                action = processAdminRequest(request);
            } else {
                if (userPath.equals("/view")) {
                    action = processViewRequest(request);
                } else {
                    if (userPath.equals("/post")) {
                        action = processPostRequest(request);
                    } else {
                        if (userPath.equals("/comm")) {
                            action = processCommRequest(request,response);
                        } else {
                            if (userPath.equals("/")) {
                                action = "index";
                            }
                        }
                    }
                }
            }
        }
        
        if( action != null) {
            if( !action.equals( DO_AJAX_RESP) ) {
                request.getRequestDispatcher("/WEB-INF/view/"+action+".jsp").forward(request, response);
            }
        } else {
            replyError(request, response, "The required action is not found: '" + userPath);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
