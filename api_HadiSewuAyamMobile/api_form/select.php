<?php
include 'connection.php';
$query = mysqli_query($con, "SELECT * FROM hadisewu_sales_visit");
$data = array();
$qry_array = array();
$i = 0;
$total = mysqli_num_rows($query);
while ($row = mysqli_fetch_array($query)) {
  $data['id'] = $row['id'];
  $data['tanggal_kunjungan'] = $row['tanggal_kunjungan'];
  $data['nama'] = $row['nama'];
  $data['kontak'] = $row['kontak'];
  $data['alamat'] = $row['alamat'];
  $data['pemilik'] = $row['pemilik'];
  $data['kebutuhan'] = $row['kebutuhan'];
  $data['penanggungjawab'] = $row['penanggungjawab'];
  $data['keterangan'] = $row['keterangan'];
  $data['ttl'] = $row['ttl'];
  $data['area'] = $row['area'];

  $qry_array[$i] = $data;
  $i++;
}

if($query){
  $response['success'] = 'true';
  $response['message'] = 'Data Loaded Successfully';
  $response['total'] = $total;
  $response['data'] = $qry_array;
}else{
  $response['success'] = 'false';
  $response['message'] = 'Data Loading Failed';
}

echo json_encode($response);
?>
