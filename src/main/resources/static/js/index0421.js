// login.jsp // 로그인 기능 자바스크립트
let login_form = {
    init:function (){ // 화면에 이벤트 처리
        $('#login_btn').click(function (){
            login_form.send();
        });
    },
    send:function () {
        $('#login_form').attr({
            'action':'/loginimpl', // maincontroller 로 보낸다.
            'method':'post'
        });
        $('#login_form').submit();
    }
};

// jsp01.jsp // 제목 다른 텍스트(num_로 바꾸기
let jsp01 = {
    data:0,
    init:function (num) {
        this.data = num;
        this.display();
    },
    display:function (){
        $('#jsp01').text(this.data+''); //  id : jsp01인 영역에 data를 뿌려줘라.
    }
};
