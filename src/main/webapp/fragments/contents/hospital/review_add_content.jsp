<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="review_emoji" style="">
    <div id="modal_text" class="d-flex">
        <div id="review_user_name" class="m-2 p-2" style="font-weight:bold">${sessionScope.username}님! </div>
        <div id="review_hospital_name" class="m-2 p-2" style="font-weight:bold">은(는) 어떠셨나요?</div>
    </div>

    <form id="review_submit_form">
        <input id="review_submit_hpid" type="hidden" name="hpid">

        <div id="add_best" class="add_best d-flex m-4 " style="height: 15%;">
            <input type="radio" id="best" name="rate" value=5 style="display: none;">
            <label for="best">
                <img id='bestImage' onclick='changeImageBest()'
                     src="https://creazilla-store.fra1.digitaloceanspaces.com/emojis/48205/smiling-face-with-smiling-eyes-emoji-clipart-md.png"
                     class="smile"
                     alt width="44"
                     height="44">
                <b class="m-2"> "최고에요 (5점)" </b>
            </label>
        </div>

        <div id="add_good" class="add_good d-flex m-4 " style="height: 15%;">
            <input type="radio" id="good" name="rate" value="4" style="display: none;">
            <label for="good">
                <img id='goodImage' onclick='changeImageGood()'
                     src="https://creazilla-store.fra1.digitaloceanspaces.com/emojis/47713/smiling-face-emoji-clipart-md.png"
                     class="smile"
                     alt width="44"
                     height="44">
                <b class="m-2"> "좋아요 (4점)" </b>
            </label>
        </div>

        <div id="add_normal" class="add_normal d-flex m-4 " style="height: 15%;">
            <input type="radio" id="normal" name="rate" value="3" style="display: none;">
            <label for="normal">
                <img id='normalImage' onclick='changeImageNormal()'
                     src="/resource/assets/img/emoji/aZHCfuhGuOOYwW2qVXWHexwrRIyJANgCLjN7lWOdmbO21vE_d90xpVXz3SyMYtehQnyruxenEMnVAeigcZf6cQ.svg"
                     class="smile"
                     alt width="44"
                     height="44">
                <b class="m-2"> "그냥 그래요 (3점)" </b>
            </label>
        </div>

        <div id="add_bad" class="add_bad d-flex m-4 " style="height: 15%;">
            <input type="radio" id="bad" name="rate" value="2" style="display: none;">
            <label for="bad">
                <img id='badImage' onclick='changeImageBad()'
                     src="https://w7.pngwing.com/pngs/699/293/png-transparent-emoji-emoticon-expression-annoyed-emoji-icon-thumbnail.png"
                     class="smile"
                     alt width="44"
                     height="44">
                <b class="m-2"> "별로에요 (2점)" </b>
            </label>
        </div>

        <div id="add_worst" class="add_worst d-flex m-4 " style="height: 15%;">
            <input type="radio" id="worst" name="rate" value="1" style="display: none;">
            <label for="worst">
                <img id='worstImage' onclick='changeImageWorst()'
                     src="https://creazilla-store.fra1.digitaloceanspaces.com/emojis/55893/angry-face-emoji-clipart-md.png"
                     class="smile"
                     alt width="44"
                     height="44">
                <b class="m-2"> "최악이에요 (1점)" </b>
            </label>

            <div id="submit_div" class="ab w-50 h-50 m-2 p-2">
                <button type="submit" style="border: none; padding: 0; background: none;" onclick="calReviewAddHandler()">
                    <img src="/resource/assets/img/emoji/image_processing20200510-10310-2x47zj(3).svg"
                         class="smile img-fluid mb-5 pb-5">
                </button>
            </div>
        </div>
    </form>
</div>
