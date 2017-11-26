<?php

$hostname='localhost';
$username='root';
$password='';
date_default_timezone_set('Asia/Jakarta');
$dbh = new PDO("mysql:host=$hostname;dbname=db_pariwisata",$username,$password);

$dbh->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION); // <== add this line
//echo 'Connected to Database<br/>';
?>