function textAreaHeightSet(argObj){
    argObj.style.height = "10px";
    var wSclollHeight = parseInt(argObj.scrollHeight);
    // 1行の長さを取得する
    var wLineH = parseInt(argObj.style.lineHeight.replace(/px/, ''));
    // 最低2行の表示エリアにする
    if(wSclollHeight < (wLineH * 2)){wSclollHeight=(wLineH * 2);}
    // テキストエリアの高さを設定する
    argObj.style.height = wSclollHeight + "px";
}

//テキストエリアの高さを可変にする
$(function () {
    $('#textarea').on('input', function () {
        if ($(this).outerHeight() > this.scrollHeight) {
            $(this).height(1)
        }
        while ($(this).outerHeight() < this.scrollHeight) {
            $(this).height($(this).height() + 1)
        }
    });
});

//input要素を可変にする
$(document).ready(function() {
    var $inputText = $('.js-input-text');
    var $dummyInputText = $('.js-dummy-input-text');

    function updateValue(e) {
        var value = $(e.target).val();
        $(e.target).prev($dummyInputText).text(value);
    }

    $inputText.on('keyup', updateValue);
    $inputText.on('compositionend', updateValue);
});