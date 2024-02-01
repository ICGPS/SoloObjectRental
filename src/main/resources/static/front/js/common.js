window.addEventListener("DOMContentLoaded", function() {

    // 페이지 내 스크롤을 화면 크기만큼 내리면 Top버튼 나오도록
    window.addEventListener('scroll', function() {
    // 현재 스크롤 위치
        var scrollHeight = window.scrollY;

        // 화면 높이
        var windowHeight = window.innerHeight;

        const topBtn = document.getElementById('btn_top');
        // 화면 맨 위에서부터 화면 높이보다 아래로 내려갔을 때 이벤트 발생
        if (scrollHeight >= windowHeight) {
            // 여기에 이벤트 발생 시 실행할 동작 추가
            topBtn.style.visibility = 'visible';
        } else if (scrollHeight < windowHeight) {
            topBtn.style.visibility = 'hidden';
        }
    });

});