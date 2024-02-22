FROM rust:alpine AS builder

WORKDIR /usr/src/dcs-dach-bot
ADD . ./

RUN apk update && \
    apk upgrade

RUN apk add --no-cache musl-dev

RUN cargo build --release

FROM alpine:latest
WORKDIR /opt

COPY --from=builder /usr/src/dcs-dach-bot/target/release/chruldatabase /opt/chruldatabase

CMD ["/opt/chruldatabase"]