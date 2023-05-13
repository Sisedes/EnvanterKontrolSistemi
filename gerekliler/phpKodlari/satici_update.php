<?php
require "baglanti.php";

if(!empty($_POST['satici_id']&&$_POST['satici_ad']&&$_POST['telefon_no']&&$_POST['e_posta']&&$_POST['adres']&&$_POST['sehir_id'])){
    $satici_id=$_POST['satici_id'];
    $satici_ad=$_POST['satici_ad'];
    $telefon_no=$_POST['telefon_no'];
    $e_posta=$_POST['e_posta'];
    $adres=$_POST['adres'];
    $sehir_id=$_POST['sehir_id'];

    if($bag)
    {
        $sql="UPDATE satici set satici_ad ='".$satici_ad."',telefon_no='".$telefon_no."',e_posta='".$e_posta."',adres='".$adres."',sehir_id='".$sehir_id."' WHERE satici_id = ". $satici_id;
        if(mysqli_query($bag,$sql))
        {
            echo "Guncellendi.";
        }else echo "Guncellenemedi";
    }else echo "Veritabanina Baglanmadi";

}
?>