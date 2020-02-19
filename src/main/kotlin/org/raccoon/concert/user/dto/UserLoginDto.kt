package org.raccoon.concert.user.dto

import javax.validation.constraints.NotNull

class UserLoginDto(
        @NotNull var userId : String,
        @NotNull var password : String

)