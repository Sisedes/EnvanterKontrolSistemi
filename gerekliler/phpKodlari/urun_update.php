<?php
require "baglanti.php";

if(!empty($_POST['urun_id']&&$_POST['isim']&&$_POST['stok_bilgi']&&$_POST['fiyat']&&$_POST['depo_id']))
{
    $urun_id=$_POST['urun_id'];
    $isim=$_POST['isim'];
    $fiyat=$_POST['fiyat'];
    $stok_bilgi=$_POST['stok_bilgi'];
    $depo_id=$_POST['depo_id'];
    if($bag)
    {
        $sql="UPDATE urun_bilgi set isim ='".$isim."',fiyat='".$fiyat."',stok_bilgi='".$stok_bilgi."',depo_id='".$depo_id."' WHERE urun_id = ". $urun_id;
        if(mysqli_query($bag,$sql))
        {
            echo "Guncellendi.";
        }else echo "Guncellenemedi";
    }else echo "Veritabanina Baglanmadi";

}
?>