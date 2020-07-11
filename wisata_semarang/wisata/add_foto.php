<?php
require_once('../config/koneksi.php');

if(isset($_FILES['file']['name']) && 
   isset($_POST['nama_foto'])
   ){
	   $file_path = "../img/wisata/";
	   $file_path = $file_path . basename( $_FILES['file']['name']);
	$nama_foto = $_POST['nama_foto'];
	
	
	
	if (file_exists($file_path)) {
		$json['message'] = 'Gambar sudah ada';
		$json['gambar'] = "".$file_path;
		$json['success'] = false;
		echo json_encode($json);
	}else{
		try {
			$sql="INSERT INTO `foto_wisata` ( `nama_foto`) VALUES ('".$nama_foto."');";
			$ss = $dbh->prepare($sql);
			$ss->execute();
			if($ss){
				  
				if(move_uploaded_file($_FILES['file']['tmp_name'], $file_path)){
							$json['message'] = "Success Create Wisata";
							$json['success'] = true;
							$json['gambar'] = "".$file_path;
							echo json_encode($json);
				}else{
							$sth3 = $dbh->prepare("DELETE FROM `foto_wisata`  WHERE `nama_wisata` = '".$nama_wisata."' ");
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