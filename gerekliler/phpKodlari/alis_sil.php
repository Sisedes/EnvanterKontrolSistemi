<?php
require "baglanti.php";
if(!empty($_POST['alis_id']))
{
    $id=$_POST['alis_id'];
    if($bag)
    {
        $sql="DELETE FROM alis_bilgi WHERE alis_id = " . $id;
        if(mysqli_query($bag,$sql))
        {
            echo "Silindi";
        }
    }else echo"Silinemedi";
}else echo"Veritabanina Baglanmadi";
?>