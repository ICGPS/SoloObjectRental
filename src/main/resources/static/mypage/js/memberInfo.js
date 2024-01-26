var element_wrap = document.getElementById('wrap');

function foldDaumPostcode() {
    element_wrap.style.display = 'none';
}

function execDaumPostcode() {
    var currentScroll = Math.max(document.body.scrollTop, document.documentElement.scrollTop);
    // 우편번호 검색 기능 추가
    // 나머지 JavaScript 코드 추가
}

// 배송지 관리 팝업 열기
function openDeliveryPopup() {
    var deliveryPopup = document.getElementById('deliveryPopup');
    deliveryPopup.style.display = 'block';
}

// 비밀번호 변경 팝업 열기
function openPasswordPopup() {
    var passwordPopup = document.getElementById('passwordPopup');
    passwordPopup.style.display = 'block';
}

document.getElementById('saveButton').addEventListener('click', function() {
    // Ajax 요청
    var xhr = new XMLHttpRequest();
    xhr.open('POST', '/saveMemberInfo');  // 저장 요청을 처리하는 서버의 엔드포인트 주소
    xhr.setRequestHeader('Content-Type', 'application/json');

    // FormData에 폼 데이터를 담아 전송
    var formData = new FormData(document.getElementById('memberInfoForm'));
    var jsonData = {};
    formData.forEach(function(value, key){
        jsonData[key] = value;
    });
    var jsonString = JSON.stringify(jsonData);

    // 성공 시 동작
    xhr.onload = function() {
        if (xhr.status === 200) {
            alert('회원 정보가 성공적으로 저장되었습니다.');
            // 저장 후 어떤 동작을 할지 여기에 추가
        } else {
            alert('회원 정보 저장에 실패했습니다.');
        }
    };

    // 에러 시 동작
    xhr.onerror = function() {
        alert('서버와의 통신 중 오류가 발생했습니다.');
    };

    // Ajax 요청 전송
    xhr.send(jsonString);
});