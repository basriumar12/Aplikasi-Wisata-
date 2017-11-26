<?php
require_once('../config/koneksi.php');

		try {
			$sql="select * from tbl_wisata";
			$ss = $dbh->prepare($sql);
			$ss->execute();
			$data=$ss->fetchAll(PDO::FETCH_OBJ);
			$size=$ss->rowCount();
			if($size > 0){
				$json['wisata']=$data;
				$json['message'] = "Success Load Wisata Semarang";
				$json['success'] = true;
				echo json_encode($json);
				
			} else{
				$json['message']='Error Load Wisata Semarang';
				$json['success'] = false;
				
				echo json_encode($json);
			}

		} catch(PDOException $e){
			$json["success"] = false;
			$json["message"] = $e->getMessage();
			echo json_encode($json);
		}
	
?> 