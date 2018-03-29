<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
     <%@page import="com.mayank.mfg.MfgController" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <style>
        .list-group{
            padding-left: 30px;
        }
    </style>
</head>
<body>

			<div class="item-list col-md-12 container-fluid">
        <div class="row">
                <div class="heading col-md-10"><h2>MANUFACTURER LIST</h2></div>
            <div class="add col-md-2">
                <!-- Button trigger modal -->
<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModalCenter">
        Add Manufacturer
      </button>
      
      <!-- Modal -->
      <div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered modal-lg" role="document">
          <div class="modal-content">
            <div class="modal-header">
              <h5 class="modal-title" id="exampleModalLongTitle">Add your Item</h5>
              <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                <span aria-hidden="true">&times;</span>
              </button>
            </div>
            <div class="modal-body">
            <form action="manufacturer" method="post">
                  
                    <div class="form-group">
                            <label for="exampleInputEmail1">Company Name</label>
                            <input  name="companyName"  type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter Company Name">
                        </div>
                    <div class="form-group">
                            <label for="exampleInputEmail1">Supervisor </label>
                            <input name="supervisor" type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter Supervisor's name">
                        </div>
                        
                    <div class="form-group">
                            <label for="exampleInputEmail1">Contact No.</label>
                            <input name="contactNo" type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter Conatct No.">
                    </div>
                    <div class="form-group">
                            <label for="exampleInputEmail1">Address</label>
                            <input name="address" type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter Address">
                    </div>
                    <div class="form-group">
                            <label for="exampleInputEmail1">GSTIN No.</label>
                            <input name="gstin" type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter GSTIN">
                    </div>
                    <button type="submit" class="btn btn-primary">Save</button>
                    </form>
            </div>
            
          </div>
        </div>
      </div>
            </div> 
            
            <div class="list col-md-12 container-fluid">
                <div class="row">
                <div class="list-group col-md-12 ">
                        <button type="button" class="list-group-item list-group-item-action disabled">
                                <div class="title col-md-12 container-fluid">
                                        <div class="row">
                                            <div class="col-md-1">S.No</div>
                                            <div class="col-md-3">Company Name</div>
                                            <div class="col-md-2">Supervisor</div>
                                            <div class="col-md-1">Contact No.</div>
                                            <div class="col-md-3">Address</div>
                                            <div class="col-md-2">GSTIN No.</div>
                                        </div>
                                    </div>
                        </button>
                        <c:forEach var="mfg" items="${mfgList}">
                        <button type="button" class="list-group-item list-group-item-action">
                                <div class="title col-md-12 container-fluid">
                                        <div class="row">
                                            <div class="col-md-1">${mfg.company_no}</div>
                                            <div class="col-md-3">${mfg.company_name}</div>
                                            <div class="col-md-2">${mfg.supervisor}</div>
                                            <div class="col-md-1">${mfg.contact_no}</div>
                                            <div class="col-md-3">${mfg.address}</div>
                                            <div class="col-md-2">${mfg.gstin_no}</div>
                                        </div>
                                    </div>
                        </button>
                        </c:forEach>
                        </div>
                </div>
            </div>
        </div>
    </div>
</body>

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</html>