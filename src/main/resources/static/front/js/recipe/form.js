// const recipeForm = {
//   /**
//    * 입력항목 추가
//    *
//    */
//   addItem(e) {
//     const el = e.currentTarget;
//
//   },
//   /**
//    * 입력항목 제거
//    *
//    */
//   deleteItem(e) {
//
//   },
//   /**
//    * 입력항목 생성
//    *
//    */
//   createItem(name) {
//     const rows = document.createElement("div");
//     const inputText = document.createElement("input");
//     const inputEa = document.createElement("input");
//     const closeButton = document.createElement("button");
//     const buttonIcon = document.createTextNode("i");
//
//     rows.className = "item_box";
//
//     inputText.type = "text";
//     inputEa.type="text";
//
//     inputText.name = name;
//     inputEa.name = `${name}Ea`;
//
//     closeButton.type = "button";
//     buttonIcon.className = "xi-close";
//
//     closeButton.appendChild(buttonIcon);
//
//     rows.appendChild(inputText);
//     rows.appendChild(inputEa);
//     rows.appendChild(closeButton);
//
//     return rows;
//   }
// };
//
// window.addEventListener("DOMContentLoaded", function() {
//   const thumbs = document.getElementsByClassName("image1_tpl_box");
//   for (const el of thumbs) {
//     thumbsClickHandler(el);
//   }
//
//   /* 입력 항목 추가 버튼 처리 S */
//   const buttons = document.getElementsByClassName("add_input_item");
//   for (const el of buttons) {
//     el.addEventListener("click", recipeForm.addItem);
//   }
//   /* 입력 항목 추가 버튼 처리 E */
// });