<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<form action="./memberJoin" method="post" enctype="multipart/form-data">
	    <div class="form-group">
	      <label for="id">ID:</label>
	      <input type="text" class="form-control" id="id" placeholder="Enter ID" name="id">
	    </div>
	    
	    <div class="form-group">
	      <label for="pw">Password:</label>
	      <input type="password" class="form-control" id="pw" placeholder="Enter password" name="pw">
	    </div>
	    <div class="form-group">
	      <label for="pw">Password:</label>
	      <input type="password" class="form-control" id="pw2" placeholder="Enter password" name="pw2">
	    </div>
	    
	    <div class="form-group">
	      <label for="name">Name:</label>
	      <input type="text" class="form-control" id="name" placeholder="Enter Name" name="name">
	    </div>
	    
	    <div class="form-group">
	      <label for="email">E-mail:</label>
	      <input type="email" class="form-control" id="email" placeholder="Enter E-mail" name="email">
	    </div>
	    
	    <div class="form-group">
	      <label for="files">File:</label>
	      <input type="file" class="form-control" id="files" name="files">
	    </div>
	    
	    <div class="checkbox">
	      <label><input type="checkbox" name="remember"> Remember me</label>
	    </div>
	    
	    <button type="submit" class="btn btn-default">Submit</button>
	  </form>