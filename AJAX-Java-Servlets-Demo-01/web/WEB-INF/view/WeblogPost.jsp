<%-- 
    Document   : WeblogPost
    Created on : Feb 6, 2015, 3:35:01 PM
    Author     : Tijron
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List" %>
<%@page import="java.util.Locale" %>
<%@page import="java.time.Instant" %>
<%@page import="java.time.format.TextStyle" %>
<%@page import="model.Posting" %>
<%@page import="model.Comment" %>
<%@page import="controller.Controller" %>
<!DOCTYPE html>
<html>
    <head>
        <link href="main.css" rel="stylesheet" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="ajax.js" type="text/javascript"></script>
        <title>JSP Page</title>
    </head>
    <body>
        <table class="header_table">
            <tr>
                <td class="header_title_cell"><h1>Post a comment</h1></td>
                <td class="header_link_cell"><a class="NavigationLink" href="./view">View My Blog</a></td>
            </tr>
        </table>
        <div class="view-left-bar">
            <div class="view-left-bar-elem">
                <div class="veiw-left-bar-info-title">About</div>
            </div>
            <div class="view-left-bar-elem">
                <div class="veiw-left-bar-info-title">Pictures</div>
                <img src="?"/>
            </div>
            <div class="view-left-bar-elem">
                <div class="veiw-left-bar-info-title">My Friends</div>
                <a class="veiw-left-bar-link" href="">Friend 1</a>
                <a class="veiw-left-bar-link" href="">Friend 2</a>
            </div>
        </div>
        <div class="view-message-comments-bar">
            <% Posting post = (Posting) request.getAttribute(Controller.POST_ATTR);
            if( post != null)
            {%>
                <div class="message">
                    <div class="message-title">
                        <%=post.getTitle()%>
                    </div>
                    <div class="message-body">
                        <%=post.getContent()%>
                    </div>
                    <div class="message-time">
                        Posted on <%=post.getDate()%>
                    </div>
                </div>
                <div id="commentsList" >
                <% List<Comment> comments = post.getComments();%>
                <% for(Comment comm : comments) {%>
                    <div class="message-comment">
                        <div class="message-comment-date">
                            <%=Controller.convertToString(comm.getDate())%>:
                        </div>
                        <%=comm.getContent()%>
                    </div>
                <%}%>
                </div>
            <%}%>
            
<!--            <form name="commentForm" method="post" action="./post">
                <div id="add-comment">
                    <input name="<%=Controller.MSG_COMMENT_PARAM%>" id="add-comment-input-text" type="text" value="">
                    <input type="hidden" name="<%=Controller.MSG_ID_PARAM%>" value="<%=post.getId()%>" /> 
                    <div id="add-comment-button-div" >
                        <input type="submit"  value="add Comment">
                    </div>
                </div>
            </form>-->
            <form name="commentForm" method="post" action="./post">
                <div id="add-comment">
                    <input id="commTextId" name="<%=Controller.MSG_COMMENT_PARAM%>" id="add-comment-input-text" type="text" value="">
                    <input type="hidden" id="msgIdId" name="<%=Controller.MSG_ID_PARAM%>" value="<%=post.getId()%>" />
                    <div id="add-comment-button-div" >
                      <input type="button" onclick="subminCommentRequest()" value="add Comment">
                    </div>
                </div>
            </form>
        </div>
    </body>
</html>
