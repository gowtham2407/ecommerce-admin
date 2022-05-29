<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>update Category And Brand</title>
</head>
<body>
	<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Category & Brand</title>
<style>

.modal {
	display: none; /* Hidden by default */
	position: fixed; /* Stay in place */
	z-index: 1; /* Sit on top */
	left: 0;
	top: 0;
	width: 100%; 
	height: 100%; 
	overflow: auto; /* Enable scroll if needed */
	background-color: rgb(0, 0, 0); 
	background-color: rgba(0, 0, 0, 0.4); 
}


.modal-content {
	background-color: #fefefe;
	margin: 15% auto; /* 15% from the top and centered */
	padding: 20px;
	border: 1px solid #888;
	width: 80%; /* Could be more or less, depending on screen size */
}


.close {
	color: #aaa;
	float: right;
	font-size: 28px;
	font-weight: bold;
}

.close:hover, .close:focus {
	color: black;
	text-decoration: none;
	cursor: pointer;
}
</style>
</head>
<body>

	<table border="2">
		<thead>
			<tr>
				<th>Category</th>
				<th>Brand Name</th>
				<th>Edit</th>
			</tr>
		</thead>
		<tbody id="renderExistingCategoryAndBrand">
		</tbody>
	</table>

	<br>
	<br>
	

	<div id="myModal" class="modal">

	
		<div class="modal-content">
			<span class="close">&times;</span>
			<h4>Edit Category & Brand</h4>
			<form action="/home.com/editCategoryAndBrand" method="post">
				<div>
					<label for="editCategory">Category</label> <input type="text"
						id="editCategory" name="category">
				</div>
				<div>
					<label for="editBrand">Brand</label> <input type="text"
						id="editBrand" name="brandName">
				</div>
				<div>
					<input type="hidden" id="editBrandid" name="brandid">
				</div>
				<div>
					<input type="submit" value="Edit" id="submit" name="submit">
				</div>
			</form>
		</div>

	</div>
	
	
	
	<button id="myBtn">Create New Category & Brand</button>


	<div id="myModal1" class="modal">

		
		<div class="modal-content">
			<span class="close">&times; </span>
			<h4>New Category & Brand</h4>
			<form action="/home.com/newCategoryAndBrand" method="post">
				<div>
					<label for="category">Category</label> <input type="text"
						id="category" name="category">
				</div>
				<div>
					<label for="brandName">Brand</label> <input type="text"
						id="brandName" name="brandName">
				</div>
				<div>
					<input type="submit" value="Create" id="submit" name="submit">
				</div>
			</form>
		</div>

	</div>
	
	<br>
	<br>
	
	<button onclick="location.href = '/updateProduct'">updateProduct</button>

	<script src="https://code.jquery.com/jquery-1.12.4.min.js"
		integrity="sha256-ZosEbRLbNQzLpnKIkEdrPv7lOy9C27hHQ+Xp8a4MxAQ="
		crossorigin="anonymous"></script>

	<script type="text/javascript">

		var modal = document.getElementById("myModal1");
	
		var btn = document.getElementById("myBtn");
	
		var span = document.getElementsByClassName("close")[1];
	
		btn.onclick = function() {
		  modal.style.display = "block";
		}
		

	
		span.onclick = function() {
		  modal.style.display = "none";
		}

		window.onclick = function(event) {
		  if (event.target == modal) {
		    modal.style.display = "none";
		  }
		}
		
		let renderExistingCategoryAndBrand = document.querySelector("#renderExistingCategoryAndBrand");
		$.ajax({
			url : '/home.com/getCategoryAndBrand',
			type : 'GET',
			success : function(response) {
				console.log(response);
				JSON.parse(response).forEach(function(e){
					console.log(e);
					let tr = document.createElement("tr");
					let category = document.createElement("td");
					category.innerHTML = e.category;
					tr.appendChild(category);
					let brandName = document.createElement("td");
					brandName.innerHTML = e.brandName;
					tr.appendChild(brandName);
					let link = document.createElement("td");
					let edit = document.createElement("button");
					edit.innerText = "Edit";
				    edit.id = JSON.stringify(e);
				    
					edit.addEventListener('click', function (event) {
						console.log(event);
				 		let modal = document.getElementById("myModal");
	 				  	modal.style.display = "block";
	 				  	
	 					// Get the <span> element that closes the modal
	 					let span = document.getElementsByClassName("close")[0];
	 				
	 					// When the user clicks on <span> (x), close the modal
	 					span.onclick = function() {
	 					  modal.style.display = "none";
	 					}
	 				
	 					// When the user clicks anywhere outside of the modal, close it
	 					window.onclick = function(eventForWindow) {
	 					  if (eventForWindow.target == modal) {
	 					    modal.style.display = "none";
	 					  }
	 					}
	 			
	 					populateSelectedElement(JSON.parse(event.target.id));
					});
					link.appendChild(edit);
					tr.appendChild(link);
					renderExistingCategoryAndBrand.appendChild(tr);
				});
			}
		});
		
		function populateSelectedElement(obj) {
			console.log(obj);
			let editCategory = document.querySelector("#editCategory");
			editCategory.value = obj.category;
			let editBrand = document.querySelector("#editBrand");
			editBrand.value = obj.brandName;
			let editBrandid = document.querySelector("#editBrandid");
			editBrandid.value = obj.brandid;
		}
	
	</script>

</body>
</html>
</body>
</html>