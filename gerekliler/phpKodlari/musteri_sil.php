<?php
require "baglanti.php";
if(!empty($_POST['musteri_id']))
{
    $id=$_POST['musteri_id'];
    if($bag)
    {
        $sql="DELETE FROM musteri_bilgi WHERE musteri_id = " . $id;
        if(mysqli_query($bag,$sql))
        {
            echo "Silindi";
        }
    }else echo"Silinemedi";
}else echo"Veritabanina Baglanmadi";
?>