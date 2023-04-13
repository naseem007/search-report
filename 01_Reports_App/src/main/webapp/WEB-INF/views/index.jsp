<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: 91797
  Date: 11-04-2023
  Time: 16:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap demo</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"
          rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
</head>
<body>


  <div class="container">
     <h3 class="pd-3 pt-3">Report Application</h3>
      <form:form action="search" modelAttribute="search" method="POST">
          <table>
              <tr>
                  <td>Plan Name: </td>
                  <td>
                      <form:select path="planName">
                         <form:option value="">-Select-</form:option>
                          <form:options items="${names}"/>
                      </form:select>
                  </td>
                  <td>Plan Status:</td>
                  <td><form:select path="planStatus">
                          <form:option value="">-Select-</form:option>
                          <form:options items="${status}"/>
                      </form:select>
                  </td>

                  <td>Gender:</td>
                  <td>
                      <form:select path="gender">
                          <form:option value="">-Select-</form:option>
                          <form:option value="Male">Male</form:option>
                          <form:option value="Female">Female</form:option>
                      </form:select>
                  </td>
              </tr>

              <tr>
                  <td>Start Date:</td>
                  <td>
                      <form:input path="planStartDate" type="date"/>
                  </td>
                  <td>End Date:</td>
                  <td>
                      <form:input path="planEndDate" type="date" />
                  </td>
              </tr>
              <tr>
                  <td>
                      <a href="/" class="btn btn-secondary">Reset</a>
                  </td>
                  <td><input type="submit" value="Search"
                          class="btn btn-primary"></td>
              </tr>
          </table>

      </form:form>
      <hr/>
      <hr/>
      Export: <a href="">Excel</a> <a href="">Pdf</a>
      <hr/>
      <hr/>

      <table class="table table-striped table-hover">
          <thead>
          <tr>
              <th>S.No</th>
              <th>Holder Name</th>
              <th>Gender</th>
              <th>Plan Name</th>
              <th>Plan Status</th>

              <th>Start Date</th>
              <th>End Date</th>
              <th>Benefit Amount</th>
          </tr>
          </thead>
          <tbody>
          <c:forEach items="${plans}" var="plan" varStatus="index">
              <tr>
                  <td>${index.count}</td>
                  <td>${plan.citizenName}</td>
                  <td>${plan.gender}</td>
                  <td>${plan.planName}</td>
                  <td>${plan.planStatus}</td>
                  <td>${plan.planStartDate}</td>
                  <td>${plan.planEndDate}</td>
                  <td>${plan.benefitAmount}</td>
              </tr>
          </c:forEach>
          <tr>
          <c:if test="${empty plans}">
              <td colspan="8" style="text-align: center">No Record Found</td>
          </c:if>
          </tr>
          </tbody>
      </table>


      <button class="btn btn-red">Search</button>
  </div>


<script
        src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>

</body>
</html>
