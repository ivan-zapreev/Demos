<%-- 
    Document   : WeblogAdmin
    Created on : Feb 6, 2015, 3:33:58 PM
    Author     : Tijron
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="controller.Controller" %>
<%@page import="java.util.List" %>
<!DOCTYPE html>
<html>
    <head>
        <link href="main.css" rel="stylesheet" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>A Web Page</title>
    </head>
    <body>
        <table class="header_table">
            <tr>
                <td class="header_title_cell"><h1>My Blog Admin</h1></td>
                <td class="header_link_cell"><a class="NavigationLink" href="./view">View My Blog</a></td>
            </tr>
        </table>

        <%String title = (String) request.getAttribute(Controller.PREV_MSG_TITLE_ARRT);
        title = (title == null) ? "" : title;
        String text = (String) request.getAttribute(Controller.PREV_MSG_TEXT_ARRT);
        text = (text == null) ? "" : text;
        %>
        
        <form name="postForm" method="post" action="./admin">
            <table style="padding: 5px; border-bottom: solid 1px black;" >
                <tr>
                    <td>Title: </td>
                    <td>
                        <input name="<%= Controller.MSG_TITLE_PARAM%>" style="width: 100%;" type="text" value="<%= title%>">
                    </td>
                    <td></td>
                </tr>
                <tr>
                    <td style="vertical-align: top;">Posting:</td>
                    <td>
                        <textarea name="<%= Controller.MSG_TEXT_PARAM%>" style="width: 100%;" rows="3"><%=text%></textarea>
                    </td>
                    <td style="vertical-align: bottom;"><input style="margin-left:10px;" type="submit" value="add Posting"></td>
                </tr>
            </table>
            <input type="hidden" name="<%= Controller.MSG_DO_PARAM%>" value="true" /> 
        </form>
        <% List<String> errors = (List<String>) request.getAttribute(Controller.ERROR_LIST_ARRT);
        if( errors != null)
        {
            for(String err: errors) {%>
                <div class="error_msg">
                    <%="Error: "+err%>
                </div>
        <% }
        }%>
    </body>
</html>
