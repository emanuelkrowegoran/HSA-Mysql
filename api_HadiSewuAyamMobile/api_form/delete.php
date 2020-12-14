<?php
include 'connection.php';

$id = $_POST['id'];

$query = mysqli_query($con, "DELETE FROM hadisewu_sales_visit WHERE id = '$id' ");

if($query){
  $response['success'] = 'true';
  $response['message'] = 'Delete Data Berhasil';
}else{
  $response['success'] = 'false';
  $response['message'] = 'Delete Data Gagal';
}

echo json_encode($response);
?>
