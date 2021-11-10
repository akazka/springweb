<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<html>
<head>
	<meta charset="UTF-8">
	<title>과목 테이블 팝업</title>
	<style type="text/css">
		.required{color:red;}
		table{width:450px;}
		table th{width:120px; text-align:left;}
		input[type="text"]{width:330px;}
	</style>
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript">
		$(document).ready(function(){
			var mode = "${mode}";
			if(mode == "insert"){
				$('#insertData').attr('disabled',false);
				$('#updateData').attr('disabled',true);
				$('#deleteData').attr('disabled',true);
			}else if(mode == "update"){
				$('#insertData').attr('disabled',true);
				$('#updateData').attr('disabled',false);
				$('#deleteData').attr('disabled',false);
				
			}
			
			$("#insertData").click(function(){
				if(!validateForm()) return;
				if($("#no").val()=="") $("#no").val(0);
				if(confirm('등록을 진행할까요?')){
					$("#lessonForm").attr("action","/lesson/insertLesson.do");
					$("#lessonForm").submit();
				}
				
				
			});
			
			$("#updateData").click(function(){
				if(!validateForm()) return;
				if(confirm('수정을 진행할까요?')){
					$("#lessonForm").attr("action","/lesson/updateLesson.do");
					$("#lessonForm").submit();
				}
				
				
			});
			
			$("#deleteData").click(function(){
				if(confirm('삭제를 진행할까요?')){
					$("#lessonForm").attr("action","/lesson/deleteLesson.do");
					$("#lessonForm").submit();
				}
				
				
			});
			
			$("#closeWindow").click(function(){
				window.close();
			});
			
		});
		
		function validateForm(){
			if($("#lnum").val().replace(/\s/g,"")==""){
				alert('과목 코드를 입력해주세요.');
				return false;
			}
			
			if($("#lname").val().replace(/\s/g,"")==""){
				alert('과목명을 입력해주세요.');
				return false;
			}
			return true;
			
			
		}
</script>
</head>
<body>
	<p></p>
	<div>
			<form id="lessonForm" name="lessonForm" method="post">
				<input type="hidden" id="no" name="no" value="${lessonVO.no}" />
				<table border="1">
					<thead>
						<tr>
							<td colspan="2" align="center">
								<h4>과목 테이블 팝업창 [Spring] </h4></td>
						</tr>
					</thead>
				<tbody>
				<tr>
					<th><span class="required">*</span>과목코드</th>
					<td><input type="text" id="lnum"
						name="lnum" value="${lessonVO.lnum}" /></td>
				</tr>
				<tr>
					<th><span class="required">*</span>과목명</th>
					<td><input type="text" id="lname"
						name="lname" value="${lessonVO.lname}" /></td>
				</tr>
				</tbody>
			</table>
		</form>
	
	</div>
	<div>
	<p></p>
		<table border="0">
			<tr align="center">
				<td>
					<input type="button" id="insertData" value="등록" /></td>
				<td>
					<input type="button" id="updateData" value="수정" /></td>
				<td>
					<input type="button" id="deleteData" value="삭제" /></td>
					
				<td>
					<input type="button" id="closeWindow" value="닫기" /></td>
			</tr>
		</table>
	</div>

</body>
</html>
