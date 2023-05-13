<?php
require "baglanti.php";
if(!empty($_POST['depo_id']))
{
    $id=$_POST['depo_id'];
    if($bag)
    {
        $sql="DELETE FROM depo_bilgi WHERE depo_id = " . $id;
        if(mysqli_query($bag,$sql))
        {
            echo "Silindi";
        }
    }else echo"Silinemedi";
}else echo"Veritabanina Baglanmadi";
?>