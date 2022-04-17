<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="ie=edge">

        <title>자재내역서 등록</title>

        <style>
            .linkButton {
                all:unset;
                background-color: steelblue;
                color: white;
                padding: 5px 20px;
                border-radius: 5px;
                cursor: pointer;
                font-size: 13px;

            }

            a:hover {
                background-color: #06357a;
                color: #f0f0f0;
            }

            ul li {
                margin: 20px;
            }
        </style>

        <script type="text/javascript" >
            function winPopupTrans() {
                var popUrl = "trans";
                var popOption = "top=10, left=10, width=980, height=600, status=no, menubar=no, toolbar=no, resizable=no";
                window.open(popUrl, popOption);
            }

            function winPopupSwitch() {
                var popUrl = "switch";
                var popOption = "top=10, left=10, width=980, height=600, status=no, menubar=no, toolbar=no, resizable=no";
                window.open(popUrl, popOption);
            }
        </script>

    </head>
<body>
<h3>자재내역서 등록</h3>
    <ul>
        <li><a href="javascript:void(0);" onclick="winPopupTrans();" class="linkButton" >자재내역서 등록(변압기) - 4100100208,1188200345,1188200345,12345</a></li>
        <li><a href="javascript:void(0);" onclick="winPopupSwitch();" class="linkButton">자재내역서 등록(개페기) - 4100100209,1188200345,1188200345,12345</a></li>
    </ul>
</body>
</html>
