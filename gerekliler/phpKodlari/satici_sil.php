<?php
require "baglanti.php";
if(!empty($_POST['satici_id']))
{
    $id=$_POST['satici_id'];
    if($bag)
    {
        $sql="DELETE FROM satici WHERE satici_id = " . $id;
        if(mysqli_query($bag,$sql))
        {
            echo "Silindi";
        }
    }else echo"Silinemedi";
}else echo"Veritabanina Baglanmadi";
?>