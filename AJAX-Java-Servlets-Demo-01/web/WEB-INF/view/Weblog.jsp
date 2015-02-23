<%-- 
    Document   : Weblog
    Created on : Feb 6, 2015, 3:34:41 PM
    Author     : Tijron
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List" %>
<%@page import="model.Posting" %>
<%@page import="controller.Controller" %>

<!DOCTYPE html>
<html>
    <head>
        <link href="main.css" rel="stylesheet" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>A Web Page</title>
    </head>
        <table class="header_table">
            <tr>
                <td class="header_title_cell"><h1>My Blog</h1></td>
                <td class="header_link_cell"><a class="NavigationLink" href="./admin">Blog Admin</a></td>
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
        <div class="view-central-bar">
            <% List<Posting> posts = (List<Posting>) request.getAttribute(Controller.POSTST_ATTR);
            if( posts != null )
            {
                for(Posting post : posts )
                {%>
                <div class="message">
                    <div class="message-title">
                       <%=post.getTitle()%>
                    </div>
                    <div class="message-body">
                       <%=post.getContent()%>
                    </div>
                    <div class="message-time">
                        Posted on <%=post.getDate()%>, <a class="message-comment-link" href="./post?<%=Controller.MSG_ID_PARAM%>=<%=post.getId()%>">Comment</a>
                    </div>
                </div>
                <%}
            }%>
        </div>
</html>
