<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Teacher SingUp</title>

<script>

//Stream and Subject Table Funcation Code  
        function updateSubjectOptions() {
            var streamSelect = document.getElementById("stream");
            var subjectSelect = document.getElementById("subject");

            // Clear previous subject options
            subjectSelect.innerHTML = "";

            // Subjects for each stream
         //   var artsSubjects = ["English", "History"];  
            var artsSubjects =["English","History","Music","Geography","Education"];
            
            //var commerceSubjects = ["Economics", "Accounting"];
            var  commerceSubjects = ["Auditing", "Economics", "Corporate Law", "Income Tax", "Business"];
            
          //  var scienceSubjects = ["Physics", "Chemistry"];
            var scienceSubjects = ["Mathematics", "Physics", "Chemistry", "Biology", "Computer"];

            // Get selected stream
            var selectedStream = streamSelect.value;

            // Add subjects based on the selected stream
            if (selectedStream === "Arts") {
                artsSubjects.forEach(function(subject) {
                    var option = document.createElement("option");
                    option.value = subject;
                    option.text = subject;
                    subjectSelect.appendChild(option);
                });
            } else if (selectedStream === "Science") {
                scienceSubjects.forEach(function(subject) {
                    var option = document.createElement("option");
                    option.value = subject;
                    option.text = subject;
                    subjectSelect.appendChild(option);
                });
            } else if (selectedStream === "Commerce") {
                commerceSubjects.forEach(function(subject) {
                    var option = document.createElement("option");
                    option.value = subject;
                    option.text = subject;
                    subjectSelect.appendChild(option);
                });
            }
        }
        
        
        
 // Lab Table funcation code 
        function toggleLabNumberDropdown() {
            var labUpdateSelect = document.getElementById("lab_update");
            var labNumberSelect = document.getElementById("lab_number_row");

            // Show or hide the lab number dropdown based on "Yes/No" selection
            if (labUpdateSelect.value === "Yes") {
                labNumberSelect.style.display = "";
            } else {
                labNumberSelect.style.display = "none";
            }
        }
        
    </script>



</head>
<body>


 
        <h1> Teacher Page </h1> 
            <form action="Teacher" method="post">
                <table>
                <tr><td>Enter Teacher Id</td> <td><input type="text" placeholder="TecherID" name ="Tid" required></td></tr>
                <tr><td>Short name:</td> <td><input type="text" placeholder="Shortname" name ="Sname" required></td></tr>
                
                    <tr><td>Enter Teacher name:</td> <td><input type="text" placeholder="name" name ="name" required></td></tr>
                    
                    
                    
                    
                    
                    
                     <tr>
                <td><label for="stream">Stream:</label></td>
                <td>
                    <select id="stream" name="Stream" onchange="updateSubjectOptions()">
                        <option value="">Select Stream</option>
                        <option value="Arts">Arts</option>
                        <option value="Science">Science</option>
                        <option value="Commerce">Commerce</option>
                    </select>
                </td>
            </tr>
                    
                    
                    
                <tr>
                <td><label for="subject">Subject:</label></td>
                <td>
                    <select id="subject" name="Subject">
                        <option value="">Select Subject</option>
                    </select>
                </td>
            </tr>    
                    
     
                    
                   <!-- <tr><td>Enter Stream:</td> <td><input type="text" placeholder="Stream" name ="Stream" required></td></tr>
                    <tr><td>Enter Subject:</td><td><input type="text" placeholder="subject" name ="Subject" required></td></tr>    --> 
                    
                    
                    
                            
                    
                    
                     <tr>
                <td><label for="lab_update">Update Subject in Lab Table:</label></td>
                <td>
                    <select id="lab_update" name="lab_update" onchange="toggleLabNumberDropdown()">
                        <option value="No">No</option>
                        <option value="Yes">Yes</option>
                    </select>
                </td>
            </tr>

            <!-- Lab Number Row (Hidden initially) -->
            <tr id="lab_number_row" style="display:none;">
                <td><label for="lab_number">Select Lab Number:</label></td>
                <td>
                    <select id="lab_number" name="lab_number">
<option value="1">Lab 1</option>
<option value="2">Lab 2</option>
<option value="3">Lab 3</option>
<option value="4">Lab 4</option>
<option value="5">Lab 5</option>
<option value="6">Lab 6</option>
<option value="7">Lab 7</option>
<option value="8">Lab 8</option>
<option value="9">Lab 9</option>
<option value="10">Lab 10</option>
<option value="11">Lab 11</option>
<option value="12">Lab 12</option>
<option value="13">Lab 13</option>
<option value="14">Lab 14</option>
<option value="15">Lab 15</option>
                        <!-- Add more lab numbers as needed -->
                    </select>
                </td>
            </tr>
                    
                    
                    
                    
                    
                    
                    
                    
                    
           <!--           <tr><td>Enter Lab:</td> <td><input type="text" placeholder="name" name ="Lab" required></td></tr>                                                                                                                                       
                                        <tr><td>Enter LabNo:</td> <td><input type="text" placeholder="Labno" name ="Labno"></td></tr>
                    
                    --> 
                    
                    <tr><td>click to submit</td><td><input type="submit" placeholder="submit" value="Submit" required></td></tr>
                </table>
            </form>
     

</body>
</html>