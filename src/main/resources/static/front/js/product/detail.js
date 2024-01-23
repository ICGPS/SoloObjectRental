/**
 * 상품 상세 기능 모음
 *
 */
const productDetails = {
    /**
     * 구매 수량 변경
     *
     */
    changeEa(e) {
        const el = e.currentTarget;
        const inputEl = el.parentElement.querySelector("input[type='number']");
        let ea = parseInt(inputEl.value);
        if (el.classList.contains("down")) { // 수량 감소
            ea--;
        } else { // 수량 증가
            ea++;
        }

        ea = ea < 1 ? 1 : ea;

        inputEl.value = ea;
    }
};

window.addEventListener("DOMContentLoaded", function() {
    /* 상품 메인 썸네일 이벤트 처리 S */
    const thumbs = document.querySelectorAll(".thumbs .thumb");
    const mainImage = document.querySelector(".product_images .main_image img");
    if (mainImage) {
        for (const el of thumbs) {
            el.addEventListener("mouseenter", function() {
                const url = this.dataset.url;
                mainImage.src = url;
            });
        }
    }
    /* 상품 메인 썸네일 이벤트 처리 E */

    /* 상품 수량 증가, 감소 처리 S */
    // 버튼 클릭 시 증감
    const changeEaEls = document.querySelectorAll(".selected_products .change_ea");
    for (const el of changeEaEls) {
        el.addEventListener("click", productDetails.changeEa);
    }

    // 상품 갯수 변화(직접입력)시 상단 하단 바 연동.
    // 버튼으로 변경시 즉시 적용 X ( input 창 클릭 후 외부 클릭(blur) 시 적용 )
    const eaEls = document.querySelectorAll(".selected_products input[type='number']");
    for (const el of eaEls) {
        el.addEventListener("blur", function() {
            let ea = parseInt(this.value);
            ea = ea < 1 ? 1 : ea;
            this.value = ea;
            for (const otherEl of eaEls) {
                if (otherEl !== this) {
                otherEl.value = ea;
                }
            }
        });
    }
    /* 상품 수량 증가, 감소 처리 E */

    /** 찜하기, 장바구니, 주문하기 버튼 처리 S */
    const productActions = document.getElementsByClassName("product_action");
    for (const el of productActions) {
        el.addEventListener("click", function() {
            const mode = this.dataset.mode;
            if (mode == 'WISH') { // 찜하기

            } else { // 장바구니, 바로구매
                frmSave.mode.value = mode;
                frmSave.submit();
            }
        });
    }
    /** 찜하기, 장바구니, 주문하기 버튼 처리 E */


    /* 상단 벗어날 시 하단 바 생성 S */
    // 상단 메인 영역
    var product_main = document.getElementById('product_main');
    // 메인 영역 지날 시 보일 하단 바
    var bottomBar = document.getElementById('bottomBar');

    window.addEventListener("scroll", function () {
        // product_main 섹션의 위치 정보 가져오기
        var productMainRect = product_main.getBoundingClientRect();

        // product_main 섹션이 화면에 보일 때와 사라질 때 각각 처리
        if (productMainRect.top <= window.innerHeight && productMainRect.bottom >= 0) {

            bottomBar.style.visibility='hidden';

        } else if (productMainRect.bottom <= 0) {

            bottomBar.style.visibility='visible';

        }
    });
    /* 상단 벗어날 시 하단 바 생성 E */

});