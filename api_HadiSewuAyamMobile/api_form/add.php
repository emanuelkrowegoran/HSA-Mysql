<?php
include 'connection.php';

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

$response = array();
$query = mysqli_query($con, "INSERT INTO hadisewu_sales_visit (tanggal_kunjungan, nama, kontak, alamat, pemilik,kebutuhan,penanggungjawab,keterangan,ttl, area) VALUES ('$tanggal_kunjungan','$nama','$kontak','$alamat', '$pemilik' , '$kebutuhan' , '$penanggungjawab' , '$keterangan',   '$ttl' ,   '$area')");

if($query){
  $response['success'] = 'true';
  $response['message'] = 'Data Berhasil diTambahkan';
}else{
  $response['success'] = 'false';
  $response['message'] = 'Data Gagal diTambahkan';
}

echo json_encode($response);
?>
