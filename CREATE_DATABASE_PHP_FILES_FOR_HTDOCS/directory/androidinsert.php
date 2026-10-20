<?php
header("Content-Type: application/json");

$servername = "localhost";
$username = "root";
$password = "";
$dbname = "mysample";

$conn = new mysqli($servername, $username, $password, $dbname);
if ($conn->connect_error) {
    die(json_encode(["status" => "error", "message" => $conn->connect_error]));
}

$fname = $_POST['fname'] ?? '';

if (empty($fname)) {
    echo json_encode(["status" => "error", "message" => "Missing fname"]);
    exit;
}

$sql = "INSERT INTO personinfo (fname) VALUES (?)";
$stmt = $conn->prepare($sql);
$stmt->bind_param("s", $fname);

if ($stmt->execute()) {
    echo json_encode(["status" => "success", "message" => "Data inserted successfully"]);
} else {
    echo json_encode(["status" => "error", "message" => $stmt->error]);
}

$stmt->close();
$conn->close();
?>
