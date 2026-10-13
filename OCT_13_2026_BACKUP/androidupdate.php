<?php
$servername = "localhost";
$username = "root";
$password = "";
$dbname = "practicedb";

$conn = new mysqli($servername, $username, $password, $dbname);

if ($conn->connect_error) {
  die("Connection failed: " . $conn->connect_error);
}

// Get value from Android
$fname = $_POST['fname'] ?? '';

if (!empty($fname)) {
  // Update ALL rows
  $sql = "UPDATE customer SET fname='$fname'";
  
  if ($conn->query($sql) === TRUE) {
    echo "All records updated successfully!";
  } else {
    echo "Error updating records: " . $conn->error;
  }
} else {
  echo "No name received from app.";
}

$conn->close();
?>
