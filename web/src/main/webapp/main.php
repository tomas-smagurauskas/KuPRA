<!DOCTYPE html>
<html ng-app="KuPRA" xmlns="http://www.w3.org/1999/html">
<head>
    <meta charset='utf-8'>
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
</head>

<body>
<div class="container height60">
    <?php
     if ($_GET['u'] != '') {
         echo file_get_contents('topbar/user.html');
     }
     else {
         echo file_get_contents('topbar/guest.html');
     }
    ?>
</div>

<?php
    if ($_GET['u'] != '') {
        echo file_get_contents('menu/show.html');
        echo file_get_contents($_GET['u']);
    } else {
        echo file_get_contents('index/guest.html');
    }
?>

</body>
</html>
