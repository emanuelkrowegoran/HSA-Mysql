<?php
include 'connection.php';

$id = $_POST['id'];
$tanggal_kunjungan = $_POST['tanggal_kunjungan'];
$nama = $_POST['nama'];
$kontak = $_POST['kontak'];
$alamat = $_POST['alamat'];
$pemilik = $_POST['pemilik'];
$kebutuhan = $_POST['kebutuhan'];
$penanggungjawab = $_POST['penanggungjawab'];
$keterangan = $_POST['keterangan'];
$ttl = $_POST['ttl'];
$area = $_POST['area'];




$query = mysqli_query($con, "UPDATE hadisewu_sales_visit SET tanggal_kunjungan = '$tanggal_kunjungan', nama = '$nama', kontak = '$kontak', alamat = '$alamat' , pemilik = '$pemilik' , kebutuhan = '$kebutuhan' , penanggungjawab = '$penanggungjawab' , keterangan = '$keterangan' , ttl = '$ttl' , area = '$area' WHERE id = '$id' ");

if($query){
  $response['success'] = 'true';
  $response['message'] = 'Data Update Berhasil';
}else{
  $response['success'] = 'false';
  $response['message'] = 'Data Update Gagal';
}

echo json_encode($response);
?>
