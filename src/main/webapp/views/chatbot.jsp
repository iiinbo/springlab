<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<style>
    #me {
        width: 400px;
        height: 200px;
        overflow: auto;
        border: 2px solid blue;
    }

</style>

<script>
    let chatbot = {
        id:null,
        stompClient:null,
        init:function(){
            this.id = $('#adm_id').text();
            $("#connect").click(function() {
                chatbot.connect();
            });
            $("#disconnect").click(function() {
                chatbot.disconnect();
            });
            $("#sendme").click(function() {
                chatbot.sendMe();
            });

        },
        connect:function(){
            var sid = this.id;
            var socket = new SockJS('${adminServer}/chbot');
            this.stompClient = Stomp.over(socket);

            this.stompClient.connect({}, function(frame) {
                chatbot.setConnected(true);
                console.log('Connected: ' + frame);

                this.subscribe('/chsend/'+sid, function(msg) { // 받을준비
                    $("#me").prepend( // 뿌리는 메세지 내용
                        "<h4>" + "Chatbot" +":"+ // 나의 id : JSON.parse(msg.body).sendid
                        JSON.parse(msg.body).content1+ "</h4>");
                });
            });
        },
        disconnect:function(){
            if (this.stompClient !== null) {
                this.stompClient.disconnect();
            }
            chatbot.setConnected(false);
            console.log("Disconnected");
        },
        setConnected:function(connected){
            if (connected) {
                $("#status").text('Connected');
            } else {
                $("#status").text('Disconnected');
            }
        },
        sendMe:function(){
            var msg = JSON.stringify({ // msg 보내기.
                'sendid' : this.id,
                'content1' : $('#metext').val()
            });
            this.stompClient.send('/chatbotme', {}, msg); // chatbotme : 어드민의 챗봇컨트롤러에서 처리.
            $('#me').prepend(
                "<h4>" + this.id +":"+ // 나의 id : JSON.parse(msg.body).sendid
               $('#metext').val()+ "</h4>"
            ); // 내가 챗봇에세 작성한 내용도 채팅창에 입력해주기.
            $('#metext').val(''); // 내가 쓴 영역 다시 지우고.
        }
    };
    $(function(){
        chatbot.init();
    });

</script>
<div class="col-sm-8 text-left">
            <H1>Chatbot</H1>
            <h1 id="adm_id">${logincust.id}</h1>
            <H1 id="status">Status</H1>
            <button id="connect">Connect</button>
            <button id="disconnect">Disconnect</button>

            <h3>Me</h3>
            <input type="text" id="metext"><button id="sendme">Send</button>
            <div id="me"></div>


            </div>
