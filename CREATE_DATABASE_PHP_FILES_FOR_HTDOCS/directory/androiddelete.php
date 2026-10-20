<?php
$servername = "localhost";
$username = "root";
$password = "";
$dbname = "mysample";

$conn = new mysqli($servername, $username, $password, $dbname);

if ($conn->connect_error) {
  die("Connection failed: " . $conn->connect_error);
}

if (isset($_POST['fname'])) {
  $fname = $_POST['fname'];
  $sql = "DELETE FROM personinfo WHERE fname = '$fname'";

  if ($conn->query($sql) === TRUE) {
    echo "Record deleted successfully";
  } else {
    echo "Error deleting record: " . $conn->error;
  }
} else {
  echo "No name received.";
}

$conn->close();
?>
