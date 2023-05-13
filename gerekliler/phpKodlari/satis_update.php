<?php
require "baglanti.php";

if(!empty($_POST['satis_id']&&$_POST['musteri_id'] &&$_POST['urun_id'] &&$_POST['alis_sekli']&&$_POST['urun_adet']))
{
    $satis_id=$_POST['satis_id'];
    $musteri_id=$_POST['musteri_id'];
    $urun_id=$_POST['urun_id'];
    $alis_sekli=$_POST['alis_sekli'];
    $urun_adet=$_POST['urun_adet'];

    if($bag)
    {
        $sql="UPDATE satis_bilgi set musteri_id ='".$musteri_id."',urun_id='".$urun_id."',alis_sekli='".$alis_sekli."',urun_adet='".$urun_adet."' WHERE satis_id = ". $satis_id;
        if(mysqli_query($bag,$sql))
        {
            echo "Guncellendi.";
        }else echo "Guncellenemedi";
    }else echo "Veritabanina Baglanmadi";

}
?>