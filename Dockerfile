FROM rust:latest AS builder

WORKDIR /usr/src/chruldatabase
ADD . ./

RUN cargo build --release

FROM alpine:latest
WORKDIR /opt

COPY --from=builder /usr/src/dcs-dach-bot/target/release/chruldatabase /opt/chruldatabase

CMD ["/opt/dcs-dach-bot"]