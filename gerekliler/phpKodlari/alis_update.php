<?php
require "baglanti.php";

if(!empty($_POST['alis_id']&&$_POST['satici_id']&&$_POST['urun_id']&&$_POST['urun_adet'])){
    $alis_id=$_POST['alis_id'];
    $satici_id=$_POST['satici_id'];
    $urun_id=$_POST['urun_id'];
    $depo_id='0';
    $urun_adet=$_POST['urun_adet'];

    if($bag)
    {
        $sql="UPDATE alis_bilgi set satici_id ='".$satici_id."',urun_id='".$urun_id."',urun_adet='".$urun_adet."' WHERE alis_id = ". $alis_id;
        if(mysqli_query($bag,$sql))
        {
            echo "Guncellendi.";
        }else echo "Guncellenemedi";
    }else echo "Veritabanina Baglanmadi";

}
?>