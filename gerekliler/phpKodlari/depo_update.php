<?php
require "baglanti.php";

if(!empty($_POST['depo_id'])&&$_POST['isim']&&$_POST['sehir_id']){
    $depo_id=$_POST['depo_id'];
    $isim=$_POST['isim'];
    $sehir_id=$_POST['sehir_id'];

    if($bag)
    {
        $sql="UPDATE depo_bilgi set isim ='".$isim."',sehir_id='".$sehir_id."' WHERE depo_id = ". $depo_id;
        if(mysqli_query($bag,$sql))
        {
            echo "Guncellendi.";
        }else echo "Guncellenemedi";
    }else echo "Veritabanina Baglanmadi";

}
?>