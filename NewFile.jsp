<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Teacher SingUp</title>

<script>
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
                    
                    
                    
                    <tr><td>Enter Lab:</td> <td><input type="text" placeholder="name" name ="Lab" required></td></tr>
                                        <tr><td>Enter Lab:</td> <td><input type="text" placeholder="Labno" name ="Labno"></td></tr>
                    
                    
                    <tr><td>click to submit</td><td><input type="submit" placeholder="submit" value="Submit" required></td></tr>
                </table>
            </form>
     

</body>
</html>