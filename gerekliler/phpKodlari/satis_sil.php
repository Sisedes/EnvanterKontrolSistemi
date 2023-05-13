<?php
require "baglanti.php";
if(!empty($_POST['satis_id']))
{
    $id=$_POST['satis_id'];
    if($bag)
    {
        $sql="DELETE FROM satis_bilgi WHERE satis_id = " . $id;
        if(mysqli_query($bag,$sql))
        {
            echo "Silindi";
        }
    }else echo"Silinemedi";
}else echo"Veritabanina Baglanmadi";
?>