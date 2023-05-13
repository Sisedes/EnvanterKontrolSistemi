<?php
require "baglanti.php";
if(!empty($_POST['urun_id']))
{
    $id=$_POST['urun_id'];
    if($bag)
    {
        $sql="DELETE FROM urun_bilgi WHERE urun_id = " . $id;
        if(mysqli_query($bag,$sql))
        {
            echo "Silindi";
        }
    }else echo"Silinemedi";
}else echo"Veritabanina Baglanmadi";
?>