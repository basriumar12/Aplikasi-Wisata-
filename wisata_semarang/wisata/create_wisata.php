<?php
require_once('../config/koneksi.php');

if(
  
   isset($_POST['nama_wisata']) &&
   isset($_POST['gambar_wisata']) &&
   isset($_POST['deksripsi_wisata']) &&
   isset($_POST['event_wisata']) &&
   isset($_POST['longitude_wisata']) &&
   isset($_POST['latitude_wisata']) &&
   isset($_POST['alamat_wisata']) &&
   isset($_POST['gambar1']) &&
   isset($_POST['gambar2'] )&&
   isset($_POST['gambar3'])   ){
	   $file_path = "../img/wisata/";
	   $file_path = $file_path . basename( $_FILES['file']['name']);
	$nama_wisata = $_POST['nama_wisata'];
	$gambar_wisata = $_POST['gambar_wisata'];
	$deksripsi_wisata = $_POST['deksripsi_wisata'];
	$alamat_wisata = $_POST['alamat_wisata'];
	$event_wisata = $_POST['event_wisata'];
	$latitude_wisata = $_POST['latitude_wisata'];
	$longitude_wisata = $_POST['longitude_wisata'];
	$gambar1 = $_POST['gambar1'];
	$gambar2 = $_POST['gambar2'];
	$gambar3 = $_POST['gambar3'];
	

		try {
			$sql="INSERT INTO `tbl_wisata` ( `nama_wisata`, `gambar_wisata`, 
			`deksripsi_wisata`, `alamat_wisata`, `event_wisata`, 
			`latitude_wisata`, `longitude_wisata`,
			`gambar1`,
			`gambar2`,
			`gambar3`
			) VALUES ('".$nama_wisata."', 
			'".$gambar_wisata."', 
			'".$deksripsi_wisata."', 
			'".$alamat_wisata."', 
			'".$event_wisata."', 
			'".$latitude_wisata."', 
			'".$longitude_wisata."',
			'".$gambar1."',
			'".$gambar2."',
			'".$gambar3."'
	
			);";
			$ss = $dbh->prepare($sql);
			$ss->execute();
			if($ss){
				
				$json['message'] = "Success Create Wisata";
							$json['success'] = true;
							echo json_encode($json);
	                
			} else{
				$json['message']='Error';
				$json['success'] = false;
				
				echo json_encode($json);
			}

		} catch(PDOException $e){
			$json["success"] = false;
			$json["message"] = $e->getMessage();
			echo json_encode($json);
		}
	
} else{
	$json["success"] = false;
    $json["message"] = 'Inputan salah';
    echo json_encode($json);
}
?> 