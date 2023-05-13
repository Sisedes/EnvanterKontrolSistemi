<?php
header('Content-Type:application/json');
require "baglanti.php";
$data=array();
if($bag)
{
    $sql="SELECT *FROM satici";
    $result=mysqli_query($bag,$sql);
    if(mysqli_num_rows($result)!=0)
    {
        $i=0;
        while($row=mysqli_fetch_assoc($result))
        {
            $data[$i]=$row;
            $i++;
        }
        echo json_encode($data, JSON_PRETTY_PRINT);
    }
}else echo "Veritabanina Baglanmadi";

?>