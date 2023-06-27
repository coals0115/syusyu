document.addEventListener("DOMContentLoaded", function () {
    const loginBtn = document.querySelector('#btn_login'); // 로그인 버튼

    // 로그인 버튼을 누른다.
    loginBtn.addEventListener('click', () => {
        // 1. 유효성 검사를 한다.
        if (!validateLogin()) {
            // 1-2. 유효성 검사를 통과하지 못하면 입력되지 않은 값을 alert로 띄워준다.
            console.log("test");
            return;
        }
        // 1-1. 유효성 검사를 통과하면 로그인을 시킨다.
        login();
    });

});

function validateLogin() {
    const id = document.getElementById('login_id');
    const pwd = document.getElementById('login_pwd');

    if (!id.value) {
        alert("아이디를 입력해주세요");
        id.focus();

        return false;
    }

    if (!pwd.value) {
        alert("비밀번호를 입력해주세요");
        pwd.focus();

        return false;
    }

    return true;
}

function login() {
    // ajax로 로그인 컨트롤러 메서드를 ajax로 호출한다.
    // 매개변수 : 아이디, pw

    const param = {
        lginId: document.getElementById('login_id').value,
        lginPwd: document.getElementById('login_pwd').value
    }

    $.ajax({
        type: 'POST',
        url: '/login/login',
        contentType: 'application/json; charset=utf-8',
        data: JSON.stringify(param),
        success: function (result) {
            if (result == 'success') {
                location.href = '/';
            } else {
                alert("아이디나 비밀번호를 잘못 입력하셨습니다.");
            }
            // result === 'success' -> 메인 화면으로 보내기
            // result === 'fail' -> 아이디 비번 잘못 입력했다고 메시지 띄워주기
        },
        error: function () {
            alert("error")
        }
    });
}
