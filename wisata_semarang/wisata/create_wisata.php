<?php
require_once('../config/koneksi.php');

if(isset($_FILES['file']['name']) && 
   isset($_POST['nama_wisata']) &&
   isset($_POST['gambar_wisata']) &&
   isset($_POST['deksripsi_wisata']) &&
   isset($_POST['event_wisata']) &&
   isset($_POST['longitude_wisata']) &&
   isset($_POST['latitude_wisata']) &&
   isset($_POST['alamat_wisata'])  ){
	   $file_path = "../img/wisata/";
	   $file_path = $file_path . basename( $_FILES['file']['name']);
	$nama_wisata = $_POST['nama_wisata'];
	$gambar_wisata = $_POST['gambar_wisata'];
	$deksripsi_wisata = $_POST['deksripsi_wisata'];
	$alamat_wisata = $_POST['alamat_wisata'];
	$event_wisata = $_POST['event_wisata'];
	$latitude_wisata = $_POST['latitude_wisata'];
	$longitude_wisata = $_POST['longitude_wisata'];
	
	
	if (file_exists($file_path)) {
		$json['message'] = 'Gambar sudah ada';
		$json['success'] = false;
		echo json_encode($json);
	}else{
		try {
			$sql="INSERT INTO `tbl_wisata` ( `nama_wisata`, `gambar_wisata`, `deksripsi_wisata`, `alamat_wisata`, `event_wisata`, `latitude_wisata`, `longitude_wisata`) VALUES ('".$nama_wisata."', '".$gambar_wisata."', '".$deksripsi_wisata."', '".$alamat_wisata."', '".$event_wisata."', '".$latitude_wisata."', '".$longitude_wisata."');";
			$ss = $dbh->prepare($sql);
			$ss->execute();
			if($ss){
				  
				if(move_uploaded_file($_FILES['file']['tmp_name'], $file_path)){
							$json['message'] = "Success Create Wisata";
							$json['success'] = true;
							echo json_encode($json);
				}else{
							$sth3 = $dbh->prepare("DELETE FROM `tbl_wisata`  WHERE `nama_wisata` = '".$nama_wisata."' and latitude_wisata = '".$latitude_wisata."' and longitude_wisata = '".$longitude_wisata."' and event_wisata = '".$event_wisata."'");
							$sth3->execute();
							if($ss){
								$json['message'] = "Error Create Wisata".$file_path;
								$json['success'] = false;
								echo json_encode($json);
							} else{
								$json['message']='Error';
								$json['success'] = false;
								
								echo json_encode($json);
							}		
				}
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
	}
} else{
	$json["success"] = false;
    $json["message"] = 'Inputan salah';
    echo json_encode($json);
}
?> 