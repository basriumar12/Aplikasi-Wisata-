<?php
// 	mysql_connect("localhost","micq6558_a","micq6558_db");
// 	mysql_select_db("micq6558_event");
$hostname='localhost';
$username='root';
$password='';
date_default_timezone_set('Asia/Jakarta');
$dbh = new PDO("mysql:host=$hostname;dbname=db_wisata",$username,$password);

$dbh->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION); // <== add this line
//echo 'Connected to Database<br/>';
?>