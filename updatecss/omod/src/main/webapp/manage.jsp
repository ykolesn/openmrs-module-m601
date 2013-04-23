<%@ include file="/WEB-INF/template/include.jsp"%>
<%@ include file="/WEB-INF/template/header.jsp"%>

<%@ include file="template/localHeader.jsp"%>

<p>Hello ${user.systemId}!</p>
<form:form modelAttribute="updateCSS" method="POST" action="updateCSS.form" >
	<table cellpadding="10">
		<tr>
		<td>
        <form:label path="homeDirectory"><b>CSS File Path:</b></form:label>
        </td>
        </tr>
        <tr>
        <td>
        <form:input size="125" path="homeDirectory" />
        </td>
        </tr>
        <tr>
        <td>
  	 	<form:label path="cssData"><b>Custom CSS:</b></form:label>
  	 	</td>
  	 	</tr>
  	 	<tr>
  	 	<td>
  	 	<form:textarea rows="30" cols="125" path="cssData" />
  	 	</td>
    	</tr>
    	<tr>
    	<td>
    	<input type="submit" value="Save Settings"/>
    	</td>
    	</tr>
    </table>
 </form:form>

<%@ include file="/WEB-INF/template/footer.jsp"%>