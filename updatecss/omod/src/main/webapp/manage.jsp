<%@ include file="/WEB-INF/template/include.jsp"%>
<%@ include file="/WEB-INF/template/header.jsp"%>

<%@ include file="template/localHeader.jsp"%>

<p>Hello ${user.systemId}!</p>
<form:form modelAttribute="updateCSS" method="POST" action="updateCSS.form" >
	<table cellpadding="10">
		<tr>
        <form:label path="homeDirectory"><b>CSS File Path:</b></form:label>
        <form:input size="125" path="homeDirectory" />
        </tr>
        <tr>
  	 	<form:label path="cssData"><b>Custom CSS:</b></form:label>
  	 	<form:textarea rows="30" cols="125" path="cssData" />
    	</tr>
    	<tr>
    	 	<input type="submit" value="Save Settings"/>
    	</tr>
    </table>
 </form:form>

<%@ include file="/WEB-INF/template/footer.jsp"%>