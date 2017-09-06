<#include "../../header.ftl">
<!--maincontent-->
<div class="mainWrap navslide">
    <div class="ui equal width left aligned padded grid stackable">
        <div class="row">
            <div class="sixteen wide tablet sixteen wide computer column">
                <div class="ui segments">
                    <div class="ui segment">
                        <h5 class="ui header">
                            Manipulating Forms
                        </h5>
                    </div>
                    <form class="ui form segment form4">
                        <div class="two fields">
                            <div class="field">
                                <label>Name</label>
                                <input placeholder="First Name" name="name" type="text">
                            </div>
                            <div class="field">
                                <label>Gender</label>
                                <div class="ui selection dropdown" tabindex="0">
                                    <input name="gender" type="hidden">
                                    <div class="default text">Gender</div>
                                    <i class="dropdown icon"></i>
                                    <div class="menu" tabindex="-1">
                                        <div class="item" data-value="male">Male</div>
                                        <div class="item" data-value="female">Female</div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="field">
                            <label>Username</label>
                            <input placeholder="Username" name="username" type="text">
                        </div>
                        <div class="field">
                            <label>Password</label>
                            <input name="password" type="password">
                        </div>
                        <div class="inline field">
                            <div class="ui checkbox">
                                <input name="terms" type="checkbox" tabindex="0" class="hidden">
                                <label>I agree to the terms and conditions</label>
                            </div>
                        </div>
                        <div class="ui blue submit button">Submit</div>
                        <div class="ui reset button">Reset</div>
                        <div class="ui clear button">Clear</div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<!--maincontent-->