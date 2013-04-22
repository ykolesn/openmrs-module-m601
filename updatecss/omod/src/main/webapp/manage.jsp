<%@ include file="/WEB-INF/template/include.jsp"%>
<%@ include file="/WEB-INF/template/header.jsp"%>

<%@ include file="template/localHeader.jsp"%>

<p>Hello ${user.systemId}!</p>
<form:form modelAttribute="updateCSS" method="POST" action="updateCSS.form" >
	<table>
		<tr>
        <form:label path="homeDirectory"><b>Tomcat Home Directory:</b></form:label>
        <form:input path="homeDirectory" />
        </tr>
        <tr>
  	 	<form:label path="cssData"><b>Custom CSS:</b></form:label>
  	 	<form:textarea path="cssData" />
    	</tr>
    	<tr>
    	 	<input type="submit" value="Save Settings"/>
    	</tr>
    </table>
 </form:form>

<%@ include file="/WEB-INF/template/footer.jsp"%>