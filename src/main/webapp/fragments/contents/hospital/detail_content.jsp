<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="d-flex m-1" style="height:1400px; background-color:#1977cc; border-radius:10px">
    <section id="detail" class=" detail_section_bg" style="width:700px">

        <!-- <div class="border  p-1 m-3  h-100" style='background-col

             <div class="col-md-7 col-lg-8">
                 <h4 class="mb-3">상 세 정 보</h4>
                 <form class="needs-validation" novalidate="">
                     <div class="row g-3">
                         <div class="col-sm-6">
                             <label for="firstName" class="form-label">First name</label>
                             <input type="text" class="form-control" id="firstName" placeholder="" value="" required="">
                             <div class="invalid-feedback">
                                 Valid first name is required.
                             </div>
                         </div>

                         <div class="col-sm-6">
                             <label for="lastName" class="form-label">Last name</label>
                             <input type="text" class="form-control" id="lastName" placeholder="" value="" required="">
                             <div class="invalid-feedback">
                                 Valid last name is required.
                             </div>
                         </div>

                         <div class="col-12">
                             <label for="username" class="form-label">Username</label>
                             <div class="input-group has-validation">
                                 <span class="input-group-text">@</span>
                                 <input type="text" class="form-control" id="username" placeholder="Username" required="">
                                 <div class="invalid-feedback">
                                     Your username is required.
                                 </div>
                             </div>
                         </div>

                         <div class="col-12">
                             <label for="email" class="form-label">Email <span class="text-muted">(Optional)</span></label>
                             <input type="email" class="form-control" id="email" placeholder="you@example.com">
                             <div class="invalid-feedback">
                                 Please enter a valid email address for shipping updates.
                             </div>
                         </div>

                         <div class="col-12">
                             <label for="address" class="form-label">Address</label>
                             <input type="text" class="form-control" id="address" placeholder="1234 Main St" required="">
                             <div class="invalid-feedback">
                                 Please enter your shipping address.
                             </div>
                         </div>

                         <div class="col-12">
                             <label for="address2" class="form-label">Address 2 <span class="text-muted">(Optional)</span></label>
                             <input type="text" class="form-control" id="address2" placeholder="Apartment or suite">
                         </div>

                         <div class="col-md-5">
                             <label for="country" class="form-label">Country</label>
                             <select class="form-select" id="country" required="">
                                 <option value="">Choose...</option>
                                 <option>United States</option>
                             </select>
                             <div class="invalid-feedback">
                                 Please select a valid country.
                             </div>
                         </div>

                         <div class="col-md-4">
                             <label for="state" class="form-label">State</label>
                             <select class="form-select" id="state" required="">
                                 <option value="">Choose...</option>
                                 <option>California</option>
                             </select>
                             <div class="invalid-feedback">
                                 Please provide a valid state.
                             </div>
                         </div>

                         <div class="col-md-3">
                             <label for="zip" class="form-label">Zip</label>
                             <input type="text" class="form-control" id="zip" placeholder="" required="">
                             <div class="invalid-feedback">
                                 Zip code required.
                             </div>
                         </div>
                     </div>

                     <hr class="my-4">

                     <div class="form-check">
                         <input type="checkbox" class="form-check-input" id="same-address">
                         <label class="form-check-label" for="same-address">Shipping address is the same as my billing address</label>
                     </div>

                     <div class="form-check">
                         <input type="checkbox" class="form-check-input" id="save-info">
                         <label class="form-check-label" for="save-info">Save this information for next time</label>
                     </div>

                     <hr class="my-4">

                     <h4 class="mb-3">Payment</h4>

                     <div class="my-3">
                         <div class="form-check">
                             <input id="credit" name="paymentMethod" type="radio" class="form-check-input" checked="" required="">
                             <label class="form-check-label" for="credit">Credit card</label>
                         </div>
                         <div class="form-check">
                             <input id="debit" name="paymentMethod" type="radio" class="form-check-input" required="">
                             <label class="form-check-label" for="debit">Debit card</label>
                         </div>
                         <div class="form-check">
                             <input id="paypal" name="paymentMethod" type="radio" class="form-check-input" required="">
                             <label class="form-check-label" for="paypal">PayPal</label>
                         </div>
                     </div>

                     <div class="row gy-3">
                         <div class="col-md-6">
                             <label for="cc-name" class="form-label">Name on card</label>
                             <input type="text" class="form-control" id="cc-name" placeholder="" required="">
                             <small class="text-muted">Full name as displayed on card</small>
                             <div class="invalid-feedback">
                                 Name on card is required
                             </div>
                         </div>

                         <div class="col-md-6">
                             <label for="cc-number" class="form-label">Credit card number</label>
                             <input type="text" class="form-control" id="cc-number" placeholder="" required="">
                             <div class="invalid-feedback">
                                 Credit card number is required
                             </div>
                         </div>

                         <div class="col-md-3">
                             <label for="cc-expiration" class="form-label">Expiration</label>
                             <input type="text" class="form-control" id="cc-expiration" placeholder="" required="">
                             <div class="invalid-feedback">
                                 Expiration date required
                             </div>
                         </div>

                         <div class="col-md-3">
                             <label for="cc-cvv" class="form-label">CVV</label>
                             <input type="text" class="form-control" id="cc-cvv" placeholder="" required="">
                             <div class="invalid-feedback">
                                 Security code required
                             </div>
                         </div>
                     </div>

                     <hr class="my-4">

                     <button class="w-100 btn btn-primary btn-lg" type="submit">예약하기</button>
                 </form>
             </div>

         or:white; border-width:1px; border-color:black' ></div>
 -->

        <div class=" detail_elements  p-2 m-2 h-100 ; height:1000px "
             style='background-color:white ;   border: 2px solid black; border-radius: 10px;'>
            <div class=" p-2 w-100 h-100" style='background-color:white;  border-color:black'>


            </div>


        </div>


    </section>


    <section id="review" class="review_section_bg" style="width:700px ; border-color:black;">

        <div class=" review_elements  p-2 m-2 h-100"
             style='background-color:white ;   border: 2px solid black; border-radius: 10px; height:1000px'>
            <div class=" p-2 w-100 h-100" style='background-color:white;  border-color:black'>
                <div class="review_top"
                     style="border-width: 1px;  border-radius:10px; height:10px">
                    리뷰

                </div>

                    <div id="review1" class="review-1 border m-2 mt-4 mb-4 p-2 "
                         style="border-width: 20px ;  height:260px ">

                        <div class="border d-flex justify-content-start" style="border-radius: 10px; border-width: 20px; border-color:black; font-size:10px; height:25px">
                            <div class="p-2 bd-highlight" > 제목:  </div>


                    </div>
                        <div class="content border m-1 p-1" style=" border-width:10px; height:190px; font-size:13px; border-color:black">
                            <div class="p-2 bd-highlight" style="overflow:scroll; height:auto;" >



                            </div>
                        </div>
                        <div class="border d-flex justify-content-start" style="border-radius: 10px; border-width: 20px; border-color:black; font-size:10px; height:25px">
                            <div class="p-2 bd-highlight" > 작성자: </div>
                            <div class="p-2 bd-highlight" > 작성일:</div>
                            <div class="p-2 bd-highlight" > 평점:  </div>
                        </div>
                        </div>



                <div id="review2" class="review-1 border m-2 mt-4 mb-4 p-2 "
                     style="border-width: 20px ;  height:260px">

                    <div class="border d-flex justify-content-start" style="border-radius: 10px; border-width: 20px; border-color:black; font-size:10px; height:25px">
                        <div class="p-2 bd-highlight" > 제목:  </div>


                    </div>
                    <div class="content border m-1 p-1" style=" border-width:10px; height:190px; font-size:13px; border-color:black">
                        <div class="p-2 bd-highlight" > 내용  </div></div>
                    <div class="border d-flex justify-content-start" style="border-radius: 10px; border-width: 20px; border-color:black; font-size:10px; height:25px">
                        <div class="p-2 bd-highlight" > 작성자: </div>
                        <div class="p-2 bd-highlight" > 작성일:</div>
                        <div class="p-2 bd-highlight" > 평점:  </div>
                    </div>
                </div>

                <div id="review3" class="review-1 border m-2 mt-4 mb-4 p-2 "
                     style="border-width: 20px ;  height:260px">

                    <div class="border d-flex justify-content-start" style="border-radius: 10px; border-width: 20px; border-color:black; font-size:10px; height:25px">
                        <div class="p-2 bd-highlight" > 제목:  </div>


                    </div>
                    <div class="content border m-1 p-1" style=" border-width:10px; height:190px; font-size:13px; border-color:black">
                        <div class="p-2 bd-highlight" > 내용  </div></div>
                    <div class="border d-flex justify-content-start" style="border-radius: 10px; border-width: 20px; border-color:black; font-size:10px; height:25px">
                        <div class="p-2 bd-highlight" > 작성자: </div>
                        <div class="p-2 bd-highlight" > 작성일:</div>
                        <div class="p-2 bd-highlight" > 평점:  </div>
                    </div>
                </div>

                <div id="review4" class="review-1 border m-2 mt-4 mb-4 p-2 "
                     style="border-width: 20px ;  height:260px">

                    <div class="border d-flex justify-content-start" style="border-radius: 10px; border-width: 20px; border-color:black; font-size:10px; height:25px">
                        <div class="p-2 bd-highlight" > 제목:  </div>


                    </div>
                    <div class="content border m-1 p-1" style=" border-width:10px; height:190px; font-size:13px; border-color:black">
                        <div class="p-2 bd-highlight" > 내용  </div></div>
                    <div class="border d-flex justify-content-start" style="border-radius: 10px; border-width: 20px; border-color:black; font-size:10px; height:25px">
                        <div class="p-2 bd-highlight" > 작성자: </div>
                        <div class="p-2 bd-highlight" > 작성일:</div>
                        <div class="p-2 bd-highlight" > 평점:  </div>
                    </div>
                </div>
                <nav aria-label="Page navigation example">
                    <ul class="pagination">
                        <li class="page-item"><a class="page-link" href="#">Previous</a></li>
                        <li class="page-item"><a class="page-link" href="#">1</a></li>
                        <li class="page-item"><a class="page-link" href="#">2</a></li>
                        <li class="page-item"><a class="page-link" href="#">3</a></li>
                        <li class="page-item"><a class="page-link" href="#">Next</a></li>
                    </ul>
                </nav>

                </div>


        </div>








        <!--    <div class="d-flex ">

                 <div class="col-sm-3 w-50 form-control mx-2 my-2 px-1 py-1 " > 123</div>
                 <div class="col-sm-3 w-50 form-control mx-auto ">456</div>

         </div> -->


        <!--<section id="faq" class="faq section-bg">
            <div class="d-flex flex-wrap" style="height: 1000px;">
                <div class="border border-success  w-50 h-50" style='background-color:white'>This is default success border</div>
                <div class="border border-success  w-50 h-100" style='background-color:white'>This is default success border</div>
                <div class="border border-success  w-50 h-50" style='background-color:white'>This is default success border</div>
            </div>
        </section> -->


    </section>


</div>


